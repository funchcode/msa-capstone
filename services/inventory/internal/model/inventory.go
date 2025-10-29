package model

import "time"

type Reservation struct {
	Id        string `gorm:"primaryKey;type:varchar(32)"`
	OrderId   string `gorm:"type:varchar(32)"`
	Status    uint   `gorm:"tinyint"`
	CreatedAt time.Time
	UpdatedAt time.Time
}

type StockKeepingUnit struct {
	Sku       string `gorm:"primaryKey;type:varchar(32)"`
	OnHand    uint   `gorm:"type:int unsigned"`
	Reserved  uint   `gorm:"type:int unsigned"`
	UpdatedAt time.Time
}

type ReservationItem struct {
	ReservationId string `gorm:"type:varchar(32)"`
	Sku           string `gorm:"type:varchar(32)"`
	Qty           uint   `gorm:"type:int unsigned"`
}
