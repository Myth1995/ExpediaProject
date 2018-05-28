package com.hotels.entities;

public class UserInfo
{
    private String userId;

    private Persona persona;

    public String getUserId ()
    {
        return userId;
    }

    public void setUserId (String userId)
    {
        this.userId = userId;
    }

    public Persona getPersona ()
    {
        return persona;
    }

    public void setPersona (Persona persona)
    {
        this.persona = persona;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [userId = "+userId+", persona = "+persona+"]";
    }
}
