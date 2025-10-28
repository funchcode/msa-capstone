package main

import (
	"gin-quickstart/internal/app"
	"gin-quickstart/internal/db"
	"log"
)

func main() {
	rdb, err := db.Open(db.Config{
		DSN: "user:password@tcp(host:3306)/inventory?parseTime=true&loc=Asia%2FSeoul&charset=utf8mb4&collation=utf8mb4_0900_ai_ci",
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
