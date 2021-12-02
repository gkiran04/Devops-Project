variable "client_id" {
    default = "c3749e62-c9a9-450e-be68-e2c6610af347"
}
variable "client_secret" {
    default = "e1fe5e53-f824-48da-b39b-2e5461feff60"
}

variable "agent_count" {
    default = 1
}

variable "ssh_public_key" {
    default = "/home/ubuntu/.ssh/id_rsa"
}

variable "dns_prefix" {
    default = "akstest"
}

variable cluster_name {
    default = "akstest"
}

variable resource_group_name {
    default = "k8stest"
}

variable location {
    default = "eastus"
}

