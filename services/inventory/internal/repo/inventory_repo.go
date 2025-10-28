package repo

import "gorm.io/gorm"

type ReservationRepo struct {
	db *gorm.DB
}

func NewReservationRepo(db *gorm.DB) *ReservationRepo {
	return &ReservationRepo{db}
}
