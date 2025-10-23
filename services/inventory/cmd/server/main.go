package main

import (
	"gin-quickstart/internal/app"
	"log"
)

func main() {
	r := app.NewRouter()
	if err := r.Run(":8080"); err != nil {
		log.Fatal(err)
	}
}
