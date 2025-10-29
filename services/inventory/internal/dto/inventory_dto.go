package dto

type ReservationItemReq struct {
	SKU string `json:"sku" binding:"required"`
	Qty int    `json:"qty" binding:"required,gt=0"`
}

type ReservationReq struct {
	OrderId string               `json:"orderId" binding:"required"`
	Items   []ReservationItemReq `json:"items" binding:"required"`
}

type StockAdjustReq struct {
	SKU   string `json:"sku" binding:"required"`
	Delta int    `json:"delta" binding:"required"`
}
