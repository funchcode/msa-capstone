package app

import (
	"gin-quickstart/internal/handler"
	"gin-quickstart/internal/repo"

	"github.com/gin-gonic/gin"
	"gorm.io/gorm"
)

func NewRouter(db *gorm.DB) *gin.Engine {
	r := gin.New()

	reservationRepo := repo.NewReservationRepo(db)

	api := r.Group("/v1")
	{
		inventoryHandler := handler.NewInventoryHandler(db, reservationRepo)
		api.POST("/reservations", inventoryHandler.Reservation)
		api.POST("/reservations/:id/confirm", inventoryHandler.Confirm)
		api.POST("/reservations/:id/release", inventoryHandler.Release)
		api.GET("/stocks/:sku", inventoryHandler.GetStocks)
		api.POST("/stocks/adjust", inventoryHandler.AdjustStock)
	}

	return r
}
