variable "client_id" {
    default = "c3749e62-c9a9-450e-be68-e2c6610af347"
}
variable "client_secret" {
    default = "e8d25c1d-bd45-49bb-a799-6c4027506315"
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

