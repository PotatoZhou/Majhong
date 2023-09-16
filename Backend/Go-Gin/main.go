package main

import (
	"github.com/gin-gonic/gin"
)

func main() {
	HelloApi := gin.Default()
	HelloApi.GET("/hello", func(c *gin.Context) {
		c.JSON(200, gin.H{
			"message": "Hello, World!",
		})
	})
	r.Run(":8080")
}
