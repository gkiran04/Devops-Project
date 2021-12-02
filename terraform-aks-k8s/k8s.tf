resource "azurerm_kubernetes_cluster" "k8s" {
    name                = var.cluster_name
    location            = "East US"
    resource_group_name = "aks-rg"
    dns_prefix          = var.dns_prefix

    linux_profile {
        admin_username = "ubuntu"

        ssh_key {
            key_data = file(var.ssh_public_key)
        }
    }

    default_node_pool {
        name            = "agentpool"
        node_count      = var.agent_count
        vm_size         = "Standard_B2s"
    }

    service_principal {
        client_id     = var.client_id
        client_secret = var.client_secret
    }

    network_profile {
        load_balancer_sku = "Standard"
        network_plugin = "kubenet"
    }

    tags = {
        Environment = "Development"
    }
}