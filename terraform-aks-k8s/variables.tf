variable "client_id" {
    default = "c3749e62-c9a9-450e-be68-e2c6610af347"
}
variable "client_secret" {
    default = "2231e80f-b289-4a07-bcd5-7905a10ace18"
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

