package org.feup.rodykings.lunchlist1


class Restaurant(val name:String, val address:String, val type:String) {

    override fun toString(): String {
        return name;
    }
}