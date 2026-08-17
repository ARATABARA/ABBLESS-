package com.abbless.app.social.groups


object GroupRepository {


    private val groups =
        mutableListOf<Group>()


    fun createGroup(
        group: Group
    ){

        groups.add(group)

    }


    fun getGroups(): List<Group>{

        return groups

    }


}
