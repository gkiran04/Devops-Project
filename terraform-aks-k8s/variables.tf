variable "client_id" {
    default = "c3749e62-c9a9-450e-be68-e2c6610af347"
}
variable "client_secret" {
    default = "d47c344d-1f3f-419a-ad0f-cfcf048a4077"
}

variable "agent_count" {
    default = 1
}

variable "ssh_public_key" {
    default = "/home/jenkins/.ssh/id_rsa.pub"
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

