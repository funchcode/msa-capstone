package db

import (
	"time"

	"gorm.io/driver/mysql"
	"gorm.io/gorm"
)

type Config struct {
	DSN     string
	MaxOpen int
	MaxIdle int
	MaxLife time.Duration
}

func Open(cfg Config) (*gorm.DB, error) {
	db, err := gorm.Open(mysql.Open(cfg.DSN), &gorm.Config{
		PrepareStmt: true,
	})
	if err != nil {
		return nil, err
	}

	sqlDB, _ := db.DB()
	if cfg.MaxOpen > 0 {
		sqlDB.SetMaxOpenConns(cfg.MaxOpen)
	}
	if cfg.MaxIdle > 0 {
		sqlDB.SetMaxIdleConns(cfg.MaxIdle)
	}
	if cfg.MaxLife > 0 {
		sqlDB.SetConnMaxLifetime(cfg.MaxLife)
	}

	return db, nil
}

func Close(db *gorm.DB) error {
	sqlDB, err := db.DB()
	if err != nil {
		return err
	}

	return sqlDB.Close()
}
