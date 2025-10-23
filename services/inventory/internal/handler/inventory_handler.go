package handler

import (
	"net/http"

	"github.com/gin-gonic/gin"
)

type InventoryHandler struct{}

func NewInventoryHandler() *InventoryHandler {
	return &InventoryHandler{}
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
