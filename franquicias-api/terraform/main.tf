terraform {
  required_providers {
    docker = {
      source = "kreuzwerker/docker"
      version = "~> 3.0.2"
    }
  }
}

provider "docker" {}

resource "docker_image" "mysql" {
  name = "mysql:8"
}

resource "docker_container" "mysql" {

  image = docker_image.mysql.image_id
  name  = "mysql-franquicias"

  ports {
    internal = 3306
    external = 3306
  }

  env = [
    "MYSQL_ROOT_PASSWORD=root",
    "MYSQL_DATABASE=franquicias_db"
  ]
}