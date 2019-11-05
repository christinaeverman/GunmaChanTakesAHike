package asu.gunma.MiniGames.Models;

import com.badlogic.gdx.math.Vector2;

public class Asteroid
{
    private float velocity;
    private float direction;
    private Vector2 position;

    public Asteroid(float velocity, float direction, Vector2 position)
    {
        this.velocity = velocity;
        this.direction = direction;
        this.position = position;
    }

    // get methods
    public float getVelocity()
    {
        return velocity;
    }

    public float getDirection()
    {
        return direction;
    }

    public Vector2 getPosition()
    {
        return position;
    }

    // set methods
    public void setVelocity(float velocity)
    {
        this.velocity = velocity;
    }

    public void setDirection(float direction)
    {
        this.direction = direction;
    }

    public void setPosition(Vector2 position)
    {
        this.position = position;
    }

    // other methods

    // transforms the position of the asteroid, adding x to the current x-position and y to the current y-position
    public void transformPosition(float x, float y)
    {
        position.x += x;
        position.y += y;
    }
}
