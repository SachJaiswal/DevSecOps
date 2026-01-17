provider "google" {
  project = var.project_id
  region  = var.region
  zone    = var.zone
}

resource "google_compute_instance" "vm" {
  name         = "devsecops-vm"
  machine_type = "e2-micro"
  zone         = var.zone

  boot_disk {
    initialize_params {
      image = "debian-cloud/debian-11"
    }
  }

  network_interface {
    network = "default"
  }

  tags = ["web"]
}

# ✅ SECURE SSH FIREWALL RULE (FIXED)
resource "google_compute_firewall" "secure_ssh" {
  name    = "secure-ssh-firewall"
  network = "default"

  allow {
    protocol = "tcp"
    ports    = ["22"]
  }

  # SSH allowed ONLY from trusted IP
  source_ranges = ["103.226.145.64/32"]

  target_tags = ["web"]
}
