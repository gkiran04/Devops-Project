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
    client_id       = ""
    subscription_id = ""
    tenant_id       = ""
    client_secret   = ""
}

