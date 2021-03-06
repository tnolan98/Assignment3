import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PShape;
import processing.core.PVector;

//Green blocks
public class Target extends GameObject implements SpecialObj
{
	public static Target applet;
	
	PApplet parent;
	
	float theta;
	PShape obstacle; //shape of blocks
	
	Target(Game p)
	{
		parent = p;
		theta = 0;
		forward = new PVector(parent.random(-1,1), parent.random(-1,1));
		start();
	}
	
	//Collision handling w/ ship
	public void applyTo(Spaceship p) 
	{
		Spaceship.ammo ++;	
	}

	//Collision handling w/ shots
	public void applyTo(Shot p) 
	{
		if (Shot.type == 0)
		{
			Spaceship.score ++;
		}
	}
	
	//builds green blocks of different shapes
	void start()
	{
		obstacle = parent.createShape();
	    obstacle.beginShape();
	    parent.stroke(0, 255, 0);
	    parent.noFill();
	    parent.strokeWeight(1);
		int rand = (int) parent.random(1, 4);
	    if (rand == 1)
	    {
	      obstacle.vertex(parent.random(-20, -40), parent.random(-20, -40));
	      obstacle.vertex(parent.random(20,40), parent.random(-20, -40));
	      obstacle.vertex(parent.random(20,40), parent.random(20, 40));
	      obstacle.vertex(parent.random(-20, -40), parent.random(20, 40));
	    }
	    if (rand == 2)
	    {
	      obstacle.vertex(parent.random(-20, -40), parent.random(-20, -40));
	      obstacle.vertex(parent.random(-10, 10), parent.random(-40, -60));
	      obstacle.vertex(parent.random(20,40), parent.random(-20, -40));
	      obstacle.vertex(parent.random(20,40), parent.random(20, 40));
	      obstacle.vertex(parent.random(-20, -40), parent.random(20, 40));
	    }
	    if (rand == 3)
	    {
	      obstacle.vertex(parent.random(-20, -40), parent.random(-20, -40));
	      obstacle.vertex(parent.random(-10, 10), parent.random(-40, -60));
	      obstacle.vertex(parent.random(20,40), parent.random(-20, -40));
	      obstacle.vertex(parent.random(40,50), parent.random(10, 30));
	      obstacle.vertex(parent.random(20,40), parent.random(20, 40));
	      obstacle.vertex(parent.random(-20, -40), parent.random(20, 40));
	    }
	    if (rand == 4)
	    {
	      obstacle.vertex(parent.random(-20, -40), parent.random(-20, -40));
	      obstacle.vertex(parent.random(-10, 10), parent.random(-40, -60));
	      obstacle.vertex(parent.random(20,40), parent.random(-20, -40));
	      obstacle.vertex(parent.random(40,50), parent.random(10, 30));
	      obstacle.vertex(parent.random(20,40), parent.random(20, 40));
	      obstacle.vertex(parent.random(-20, -40), parent.random(20, 40));
	      obstacle.vertex(parent.random(-10, 10), parent.random(-10, 10));
	    }
	    obstacle.endShape(PConstants.CLOSE);
		
	}

	//renders blocks
	void render() 
	{
		parent.pushStyle();
		parent.stroke(0, 255, 0);
	    parent.strokeWeight(1);
	    parent.pushMatrix();
	    parent.translate(pos.x, pos.y);
	    parent.rotate(theta/5);
	    parent.shape(obstacle, 0, 0);
	    parent.popMatrix();
	    parent.popStyle();
		
	}

	//updates blocks
	void update() 
	{
		theta += 0.05;
		pos.add(forward);	
	}
}
