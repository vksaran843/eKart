

addProduct : 

http://localhost:9009/ekart/addProduct

{
	"productName":"laptop",

	"productDescription":"HP I5 laptop",

	"productCategory":"electonics",
	
	"taxPercentage":"10",
	
	"productQuantity":"100",
	
	"productPrice":"32000.00"
}


{
    "responseCode": "200",
    "status": "Success",
    "errorCode": null,
    "errorMessage": null,
    "responseObj": null
}





http://localhost:9009/ekart/getAllProduct

{
    "responseCode": "200",
    "status": "Success",
    "errorCode": null,
    "errorMessage": null,
    "responseObj": [
        {
            "productId": 1,
            "productName": "laptop",
            "productDescription": "HP I5 laptop",
            "productCategory": "electonics",
            "taxPercentage": "10",
            "productQuantity": 100,
            "productPrice": "32000.00",
            "status": "ACTIVE",
            "createdDate": [
                2019,
                1,
                27,
                13,
                28,
                0,
                53000000
            ]
        },
        {
            "productId": 2,
            "productName": "shirt",
            "productDescription": "black denim shirt",
            "productCategory": "clothing",
            "taxPercentage": "10",
            "productQuantity": 100,
            "productPrice": "1200.00",
            "status": "ACTIVE",
            "createdDate": [
                2019,
                1,
                27,
                13,
                30,
                46,
                339000000
            ]
        }
    ]
}




http://localhost:9009/ekart/modifyProduct


{
	
	"productId":"1",
	
	"productName":"shirt",

	"productDescription":"black denim shirt",

	"productCategory":"clothing",
	
	"taxPercentage":"10",
	
	"productQuantity":"90",
	
	"productPrice":"1100.00"
}

{
    "responseCode": "200",
    "status": "Success",
    "errorCode": null,
    "errorMessage": null,
    "responseObj": null
}



http://localhost:9009/ekart/deleteProduct


{
	
	"productId":"1"
}


{
    "responseCode": "200",
    "status": "Success",
    "errorCode": null,
    "errorMessage": null,
    "responseObj": null
}




http://localhost:9009/ekart/placeOrder

{
	
	"customerId":"1",
	
	"orderAmount":"34400.00",
	
	"paymentMode":"Net Banking",
	
	"paymentStatus":"PAID",
	
	"productList" :[
		{
		"productId":"1",
	
		"productQuantity":"1",
	
		"totalPrice":"32000.00",
		
		"status":"PLACED"
	},
		{
		"productId":"2",
	
		"productQuantity":"2",
	
		"totalPrice":"2400.00",
		
		"status":"PLACED"
	}
	
		]
}


{
    "responseCode": "200",
    "status": "Success",
    "errorCode": null,
    "errorMessage": null,
    "responseObj": null
}


http://localhost:9012/ekart/allOrderList

{
	
	"customerId":"1"

}


{
    "responseCode": "200",
    "status": "Success",
    "errorCode": null,
    "errorMessage": null,
    "responseObj": {
        "customerId": 1,
        "orderList": [
            {
                "orderId": 1,
                "orderAmount": "34400.00",
                "orderPlacedDate": [
                    2019,
                    1,
                    27,
                    14,
                    47,
                    43,
                    224000000
                ],
                "orderStatus": "PLACED",
                "productList": [
                    {
                        "productId": 1,
                        "productQuantity": 1,
                        "totalPrice": "32000.00",
                        "status": null
                    },
                    {
                        "productId": 2,
                        "productQuantity": 2,
                        "totalPrice": "2400.00",
                        "status": null
                    }
                ]
            }
        ]
    }
}

