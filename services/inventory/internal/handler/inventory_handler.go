package handler

import (
	"gin-quickstart/internal/repo"
	"net/http"

	"github.com/gin-gonic/gin"
	"gorm.io/gorm"
)

type InventoryHandler struct {
	db              *gorm.DB
	reservationRepo *repo.ReservationRepo
}

func NewInventoryHandler(db *gorm.DB, reserepo *repo.ReservationRepo) *InventoryHandler {
	return &InventoryHandler{db, reserepo}
}

/* 예약 */
func (ih *InventoryHandler) Reservation(c *gin.Context) {

	c.JSON(http.StatusOK, "")
}

/* 확정 */
func (ih *InventoryHandler) Confirm(c *gin.Context) {

	c.JSON(http.StatusOK, "")
}

/* 해제 */
func (ih *InventoryHandler) Release(c *gin.Context) {

	c.JSON(http.StatusOK, "")
}

/* 조회 */
func (ih *InventoryHandler) GetStocks(c *gin.Context) {

	c.JSON(http.StatusOK, "")
}

/* 재고조정 */
func (ih *InventoryHandler) AdjustStock(c *gin.Context) {

	c.JSON(http.StatusOK, "")
}
