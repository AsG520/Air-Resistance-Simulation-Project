# Air Resistance Simulation

Features in Simulation
- A ball that falls under gravity.
- Air resistance affecting both in vertical and horizontal directions.
- A visible floor at the bottom of the window.
- Bouncing effect with energy loss.
- Real time animation using a timer.
- Have applied forces acting in different direction towards the object.

Physics Concepts in Simulation
- Gravity Force (Fg) = m * g.
- Net Horizontal Force (Fnetx) = Fapp - FdX.
- Net Vertical Force (Fnety) = FdY - Fg.
- Horizontal Acceleration (Ax) = Fnetx / m.
- Vertical Acceleration (Ay) = Fnety / m.
- Horizontal Drag Force (FdX) = 0.5 * p * Cd * A * (vx * vx).
- Vertical Drag Force (FdY) = 0.5 * p * Cd * A * (vy * vy).

How it Works
- The program initializes variables like air density, mass, coefficient of drag, velocities, coefficient of restitution, cross sectional area, radius, acceleration, and gravity.
- It calculates all forces acting on the ball (applied force, horizontal/vertical drag force, force of gravity).
- Timer updates velocity and position continuously, when motion occurs.
- When the ball hits the bottom of the screen, it bounces back creating what is known as a collision with energy loss.
- Forces acting in different directions result the ball to not fall down in straight path.
- Demonstrates how air resistance and applied force can change motion of the ball within the simulation.
- Air resistance slows the ball down over period of time.

Requirements
- Java (JDK 8 or higher).
- IDE (e.g., VS Code, Eclipse, or IntelliJ).
- Image files:
  1) ball.png

How to Run
  1. Copy the code into a Java file named "AirResistance.java".
  2. Make sure the image file is in the same directory, or else the ball won't appear in the following window.
  3. Compile the program: "javac AirResistance.java".
  4. Run the program: "java AirResistance".

I plan to make a YouTube video that will showcase the physics behide this project, history, and a more deep explanation of the code. This video will help give me a reflection on what I learned and for others who are interested in physics and this simulation :D.
