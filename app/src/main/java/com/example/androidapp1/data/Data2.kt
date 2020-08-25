package com.example.androidapp1.data

class Data2 {
    var id: Int? = null
    var code: String? = null
    var dateBegin: String? = null
    var dateEnd: String? = null
    var status: String? = null
    var surname: String? = null
    var name: String? = null
    var patronymic: String? = null
    var phone: String? = null
    var text: String? = null
    var files: String? = null

    constructor(id: Int, code: String, dateBegin: String, dateEnd: String, status: String, surname: String, name: String, patronymic: String, phone: String, text: String, files: String){
        this.id = id
        this.code = code
        this.dateBegin = dateBegin
        this.dateEnd = dateEnd
        this.status = status
        this.surname = surname
        this.name = name
        this.patronymic = patronymic
        this.phone = phone
        this.text = text
        this.files = files

    }
}