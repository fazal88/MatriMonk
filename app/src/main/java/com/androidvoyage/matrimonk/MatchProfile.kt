package com.androidvoyage.matrimonk

class Name {
    var title: String? = null
    var first: String? = null
    var last: String? = null
}

class Street {
    var number = 0
    var name: String? = null
}

class Coordinates {
    var latitude: String? = null
    var longitude: String? = null
}

class Timezone {
    var offset: String? = null
    var description: String? = null
}

class Location {
    var street: Street? = null
    var city: String? = null
    var state: String? = null
    var country: String? = null
    var postcode: String? = null
    var coordinates: Coordinates? = null
    var timezone: Timezone? = null
}

class Login {
    var uuid: String? = null
    var username: String? = null
    var password: String? = null
    var salt: String? = null
    var md5: String? = null
    var sha1: String? = null
    var sha256: String? = null
}

class Dob {
    var date: String? = null
    var age = 0
}

class Registered {
    var date: String? = null
    var age = String
}

class Id {
    var name: String? = null
    var value: String? = null
}

class Picture {
    var large: String? = null
    var medium: String? = null
    var thumbnail: String? = null
}

class Root {
    var gender: String? = null
    var name: Name? = null
    var location: Location? = null
    var email: String? = null
    var login: Login? = null
    var dob: Dob? = null
    var registered: Registered? = null
    var phone: String? = null
    var cell: String? = null
    var id: Id? = null
    var picture: Picture? = null
    var nat: String? = null
}