variable "client_id" {
    default = "c3749e62-c9a9-450e-be68-e2c6610af347"
}
variable "client_secret" {
    default = "165497de-9d6d-4f3a-a19f-942f9fd145c2"
}

variable "agent_count" {
    default = 1
}

variable "ssh_public_key" {
    default = "~/.ssh/id_rsa.pub"
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

