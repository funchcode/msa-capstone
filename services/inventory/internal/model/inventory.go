package model

import "time"

type Reservation struct {
	Id        string `gorm:"primaryKey"`
	OrderId   string
	Status    uint
	CreatedAt time.Time
	UpdatedAt time.Time
}

type StockKeepingUnit struct {
	Sku       string `gorm:"primaryKey"`
	OnHand    uint
	Reserved  uint
	UpdatedAt time.Time
}

type ReservationItem struct {
	ReservationId string
	Sku           string
	Qty           uint
}
