terraform {
    required_providers {
      azurerm = {
        source = "hashicorp/azurerm"
        version = "~>2.0"
      }
    }
}
resource "azurerm_resource_group" "kubernetes" {
    name     = "aks-rg"
    location = "East US"
}
