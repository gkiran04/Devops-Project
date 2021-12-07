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
    client_id       = "c3749e62-c9a9-450e-be68-e2c6610af347"
    subscription_id = "57b15192-2a1f-4673-b637-1e5693ec9c16"
    tenant_id       = "b0d3d799-2a21-4cf1-ba30-3fb108d98466"
    client_secret   = "b561d908-93e6-4e9b-8c5a-0760cf1fc632"
}

