terraform {
    required_providers {
      azurerm = {
        source = "hashicorp/azurerm"
        version = "~>2.0"
      }
    }
}

provider "azurerm" {
    features {}
    subscription_id = "57b15192-2a1f-4673-b637-1e5693ec9c16"
}
resource "azurerm_resource_group" "kubernetes" {
    name     = "aks-rg"
    location = "East US"
}
