variable "client_id" {
    default = ""
}
variable "client_secret" {
    default = ""
}

variable "agent_count" {
    default = 1
}

variable "ssh_public_key" {
    default = "/var/lib/jenkins/.ssh/id_rsa.pub"
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

