/**
 * A Thread that contains the application we are going to animate
 * 
 * @author Charles Hoot 
//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>        
 * @version 4.1 (Modified for the Solution)
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
    
    
public class MazeActionThread extends ActionThread
{
    
    
    /**
     * Constructor for objects of class MazeActionThread
     */
    public MazeActionThread()
    {
        super();      
    }
    
    public String getApplicationTitle()
    {
//>>>>>>>> REPLACEMENT >>>>>>>>>>>>>>>>>>>>>>>>>       
        return "Robo-rat in the Maze (Sample)";
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    }
   
    

    // **************************************************************************
    // This is application specific code
    // **************************************************************************    

    // These are the variables that are parameters of the application and can be
    // set via the application specific GUI
    // Make sure they are initialized
    private String mazeFileName = "maze1.txt";
    private int startRow = 0;
    private int startCol = 0;
    private int goalRow = 1;
    private int goalCol = 1;
   
    
    // Displayed items
    private Maze myMaze;
    private boolean mazeLoaded = false;
    private boolean mazeLoadFailed = false;
    private boolean goalFound = false;

    

    
    public void init() 
    {
        mazeLoaded = false;
        mazeLoadFailed = false;
        goalFound = false;

        int maze[][] = getMaze(mazeFileName);
        if(maze != null)
            mazeLoaded = true;
        myMaze = new Maze(maze);
        myMaze.setStart(startRow,startCol);
        myMaze.setGoal(goalRow,goalCol);
    }
        

    public void executeApplication()
    {
        //ADD CODE HERE TO EXECUTE THE APPLICATION A SINGLE TIME
//>>>>>>>> ADDED CODE >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>       
        goalFound = searchMaze(myMaze, startRow, startCol);    
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    }
    
    private class MazeFrame
    {
        public int row;
        public int col;
        
        public MazeFrame(int r, int c)
        {
            row = r;
            col = c;
        }
    }

    
    /**
     * Search the maze.
     *
     * @param theMaze The maze to be searched.
     * @param startRow The starting row for the search.
     * @param startCol The starting col for the search.
     * @return True if Robo-rat found the battery.
     */
    public boolean searchMaze(Maze theMaze, int startRow, int startCol)
    {
    
        boolean result = false;
        //ADD SEARCH CODE HERE
    
//>>>>>>>> ADDED CODE >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>       
        Stack<MazeFrame> s = new Stack<MazeFrame>();
        MazeFrame initial = new MazeFrame(startRow, startCol);
        MazeFrame current, north, south, east, west;
        
        s.push(initial);
        while(!s.empty() && !result)
        {
            current = s.pop();
            if (theMaze.isGoal(current.row,  current.col))
            {
                result = true;  // found the battery.
                theMaze.visitSquare(current.row,  current.col);
                animationPause();
            }
            else
            {
                theMaze.visitSquare(current.row,  current.col);
                animationPause();
                // schedule visits for the four neighbors
                if(theMaze.isFree(current.row+1,  current.col))
                {
                    theMaze.scheduleSquare(current.row+1,  current.col);
                    animationPause();
                    north = new MazeFrame(current.row+1,  current.col);
                    s.push(north);
                }

                if(theMaze.isFree(current.row-1,  current.col))
                {
                    theMaze.scheduleSquare(current.row-1,  current.col);
                    animationPause();
                    south = new MazeFrame(current.row-1,  current.col);
                    s.push(south);
                }

                if(theMaze.isFree(current.row,  current.col+1))
                {
                    theMaze.scheduleSquare(current.row,  current.col+1);
                    animationPause();
                    east = new MazeFrame(current.row,  current.col+1);
                    s.push(east);
                }

                if(theMaze.isFree(current.row,  current.col-1))
                {
                    theMaze.scheduleSquare(current.row,  current.col-1);
                    animationPause();
                    west = new MazeFrame(current.row,  current.col-1);
                    s.push(west);
                }
            }

        }  
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
        return result;
    } // end searchMaze
    
    
    
    
    
    /**
     * Get the data for the maze.
     *
     * @param mazeFileName The name of the file with the maze data.
     * @return An array of ones and zeros indicating the free/walls.
     */
    public int[][] getMaze(String mazeFileName)
    {
        Scanner input;        
        int [][] theMaze;
       
        try
        {
            String inString;
            int rows, cols;
            
            input = new Scanner(new File(mazeFileName ) );
            
            // Expect number of rows and columns of data
            rows = input.nextInt();
            cols = input.nextInt();
            
            theMaze = new int[rows][cols];
            // Read the data row by row
            for(int r=0;  r<rows; r++)
                for(int c=0; c<cols; c++)
                {
                    theMaze[r][c] = input.nextInt();
                }
            
            

                            
        }
        catch(NumberFormatException e)
        {
            System.out.println("Non integer was encountered in the file: " +mazeFileName);
            System.out.println(e.getMessage());
            mazeLoadFailed = true;
            forceLastPause();
            throw new ResetApplicationException("Bad data in the maze File");
        }
        catch(Exception e)
        {
            System.out.println("There was an error in reading or opening the file: " +mazeFileName);
            System.out.println(e.getMessage());
            mazeLoadFailed = true;
            forceLastPause();
            throw new ResetApplicationException("There was a problem reading the maze File");
        }
        
        return theMaze;
 
    }
    

    private static int DISPLAY_HEIGHT = 500;
    private static int DISPLAY_WIDTH = 500;
    
    
    public JPanel createAnimationPanel()
    {
        return new AnimationPanel();
    }
    
    
    // This privately defined class does the drawing the application needs
    public class AnimationPanel extends JPanel
    {
        public AnimationPanel()
        {
            super();
            setSize(DISPLAY_WIDTH, DISPLAY_HEIGHT);
        }
        
        public void paintComponent(Graphics g)
        {
            String toDraw;
            super.paintComponent(g);
            toDraw = "Maze Loaded: " + mazeLoaded;
            g.drawString(toDraw, 20,20);
            
           if(mazeLoadFailed)
            {
                toDraw = "There were problems reading the maze; aborting";
                g.setColor(Color.red);
                g.drawString(toDraw, 20,35);
                g.setColor(Color.black);
            }    

           if(goalFound)
            {
                toDraw = "The goal was discovered";
                g.setColor(Color.red);
                g.drawString(toDraw, 20,35);
                g.setColor(Color.black);
            }    
         
            // Now draw the maze if it is available
            if(myMaze != null)
                myMaze.drawOn(g, 0, 40);
            
        }
    }
    
    // **************************************************************************
    // This is the application specific GUI code
    // **************************************************************************    

    private JTextField startRowTextField;
    private JTextField startColTextField;
    private JTextField goalRowTextField;
    private JTextField goalColTextField;
    private JTextField mazeNameTextField;

    private JLabel setupStatusLabel;
    private JPanel setupPanel;
    
    public void setUpApplicationSpecificControls()
    {
        getAnimationPanel().setLayout(new BorderLayout());
        
        
        startRowTextField = new JTextField("0");
        startRowTextField.addActionListener(
            new ActionListener() 
            {
                public void actionPerformed(ActionEvent event) 
                {
                    startTextFieldHandler();
                    getAnimationPanel().repaint();
                }
            }
        );


        startColTextField = new JTextField("0");
        startColTextField.addActionListener(
            new ActionListener() 
            {
                public void actionPerformed(ActionEvent event) 
                {
                    startTextFieldHandler();
                    getAnimationPanel().repaint();
                }
            }
        );


        goalRowTextField = new JTextField("1");
        goalRowTextField.addActionListener(
            new ActionListener() 
            {
                public void actionPerformed(ActionEvent event) 
                {
                    goalTextFieldHandler();
                    getAnimationPanel().repaint();
                }
            }
        );


        goalColTextField = new JTextField("1");
        goalColTextField.addActionListener(
            new ActionListener() 
            {
                public void actionPerformed(ActionEvent event) 
                {
                    goalTextFieldHandler();
                    getAnimationPanel().repaint();
                }
            }
        );
        
        
        mazeNameTextField = new JTextField("maze1.txt");
        mazeNameTextField.addActionListener(
            new ActionListener() 
            {
                public void actionPerformed(ActionEvent event) 
                {
                    mazeNameTextFieldHandler();
                    getAnimationPanel().repaint();
                }
            }
        );


        
        setupStatusLabel = new JLabel("");
        
        setupPanel = new JPanel();
        setupPanel.setLayout(new GridLayout(3,3));
        
        setupPanel.add(new JLabel("Start search at (Row,Col)"));
        setupPanel.add(startRowTextField);
        setupPanel.add(startColTextField);
        setupPanel.add(new JLabel("Goal at (Row,Col)"));
        setupPanel.add(goalRowTextField);
        setupPanel.add(goalColTextField);
        setupPanel.add(setupStatusLabel);
        setupPanel.add(new JLabel("Maze file name:"));
        setupPanel.add(mazeNameTextField);        
        getAnimationPanel().add(setupPanel,BorderLayout.SOUTH);
               
    }

   
   
    private void mazeNameTextFieldHandler()
    {
    try
        {
            if(applicationControlsAreActive())   // Only change if we are in the setup phase
            {
                String input = mazeNameTextField.getText().trim();
                File test = new File(input);
                if(test.canRead())
                {
                    mazeFileName = input;
                    setupStatusLabel.setText("maze file is now " + input);
                    init();
                }
                else
                {
                    setupStatusLabel.setText("Could not read " + input);
                    mazeNameTextField.setText("");
                }
                
            }
        }
        catch(Exception e)
        {
            // don't change the name if we had an exception
            setupStatusLabel.setText("bad text file name");

        }
    
    }

    // Get both x and y start coordinates from the text fields.
    private void startTextFieldHandler()
    {
    try
        {
            if(applicationControlsAreActive())   // Only change if we are in the setup phase
            {
                String inputRow = startRowTextField.getText().trim();
                int valueRow = Integer.parseInt(inputRow);
                String inputCol = startColTextField.getText().trim();
                int valueCol = Integer.parseInt(inputCol);
                if(valueRow>=0  && valueCol>=0)
                {
                    startRow = valueRow;
                    startCol = valueCol;
                    setupStatusLabel.setText(" Trying start of (" + startRow + ","+startCol+")");
                    init();
                }
                else
                {
                    setupStatusLabel.setText("Need a positive value ");
                }
                
            }
        }
        catch(Exception e)
        {
            // don't change the delta if we had an exception
            setupStatusLabel.setText("Need integer values to start at");
        }
    
    }    


    // Get both x and y goal coordinates from the text fields.
    private void goalTextFieldHandler()
    {
    try
        {
            if(applicationControlsAreActive())   // Only change if we are in the setup phase
            {
                String inputRow = goalRowTextField.getText().trim();
                int valueRow = Integer.parseInt(inputRow);
                String inputCol = goalColTextField.getText().trim();
                int valueCol = Integer.parseInt(inputCol);
                if(valueRow>=0  && valueCol>=0)
                {
                    goalRow = valueRow;
                    goalCol = valueCol;
                    setupStatusLabel.setText(" Trying goal of (" + goalRow + ","+goalCol+")");
                    init();
                }
                else
                {
                    setupStatusLabel.setText("Need a positive value ");
                }
                
            }
        }
        catch(Exception e)
        {
            // don't change the delta if we had an exception
            setupStatusLabel.setText("Need integer values for the goal");
        }
    
    }     

            
} // end class MazeActionThread

