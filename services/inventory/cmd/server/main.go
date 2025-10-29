package main

import (
	"gin-quickstart/internal/app"
	"gin-quickstart/internal/db"
	"log"
)

func main() {
	rdb, err := db.Open(db.Config{
		DSN: "root:root@tcp(127.0.0.1:3306)/inventory?parseTime=true",
	})
	if err != nil {
		log.Fatal(err)
	}
	defer func() {
		if err := db.Close(rdb); err != nil {
			log.Println("close db:", err)
		}
	}()

	r := app.NewRouter(rdb)
	if err := r.Run(":8080"); err != nil {
		log.Fatal(err)
	}
}
