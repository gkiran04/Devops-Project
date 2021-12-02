variable "client_id" {
    default = "c3749e62-c9a9-450e-be68-e2c6610af347"
}
variable "client_secret" {
    default = "370c27c8-6a0f-4e3d-af81-f7fafe118fd7"
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

