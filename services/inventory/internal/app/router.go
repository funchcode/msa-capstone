package app

import (
	"gin-quickstart/internal/handler"

	"github.com/gin-gonic/gin"
)

func NewRouter() *gin.Engine {
	r := gin.New()

	api := r.Group("/v1")
	{
		inventoryHandler := handler.NewInventoryHandler()
		api.POST("/reservations", inventoryHandler.Reservation)
		api.POST("/reservations/:id/confirm", inventoryHandler.Confirm)
		api.POST("/reservations/:id/release", inventoryHandler.Release)
	}

	return r
}
