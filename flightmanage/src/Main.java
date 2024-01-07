import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

// building ticket booking system
//what we need
//    person name email mob no source destiny date of journy birth coach seat no dob gender
public class Main {
    public static void main(String[] args) {
//        create JFrame to design frame
        JFrame frame=new JFrame("Railway Ticket Booking");
//       to provideframe size
//        to display the lables and text field
        JLabel namelb = new JLabel("Name : ");
        JTextField nametf = new JTextField();

        JLabel emaillb = new JLabel("Email : ");
        JTextField emailtf = new JTextField();

        JLabel mobnolb = new JLabel("Mobile No : ");
        JTextField mobnotf = new JTextField();

        JLabel sourcelb = new JLabel("Source :");
        JTextField sourcetf = new JTextField();

        JLabel destlb = new JLabel("Destination : ");
        JTextField desttf = new JTextField();

        JLabel dojlb = new JLabel("Date of Journy : ");
        JTextField dojtf = new JTextField();

        JLabel classpreflb = new JLabel("Class Preference : ");
        JTextField classpreftf = new JTextField();

        JLabel agelb = new JLabel("Age : ");
        JTextField ageltf= new JTextField();

        JLabel planenamelb = new JLabel("Plane Name : ");
        JTextField planenametf = new JTextField();

        JLabel genderlb = new JLabel("Gender : ");
        JTextField gendertf = new JTextField();

        JLabel idcardlb = new JLabel("ID Card No. : ");
        JTextField idcardtf = new JTextField();

        JLabel aadharlb = new JLabel("Aadhar Card No. :");
        JTextField aadhartf = new JTextField();

        JLabel panlb = new JLabel("PAN Card No. : ");
        JTextField pantf = new JTextField();

        JLabel dllb = new JLabel("DL No. : ");
        JTextField dltf = new JTextField();

        JLabel seatnotf = new JLabel();
        JLabel bookingid = new JLabel();


        JButton bookTicketBtn= new JButton("Book Now");
        JButton cancelbtn= new JButton("Cancel Button");
        JButton clearbtn= new JButton("Clear");


// set size of components and position in the frame
        namelb.setBounds(20,30,120,30);
        nametf.setBounds(140,30,150,30);
        emaillb.setBounds(20,70,120,30);
        emailtf.setBounds(140,70,150,30);
        mobnolb.setBounds(20,110,120,30);
        mobnotf.setBounds(140,110,150,30);
        agelb.setBounds(20,150,120,30);
        ageltf.setBounds(140,150,150,30);
        genderlb.setBounds(20,190,120,30);
        gendertf.setBounds(140,190,150,30);
        aadharlb.setBounds(20,230,120,30);
        aadhartf.setBounds(140,230,150,30);
        panlb.setBounds(20,270,120,30);
        pantf.setBounds(140,270,150,30);



        sourcelb.setBounds(300,30,150,30);
        sourcetf.setBounds(450,30,150,30);
        destlb.setBounds(300,70,150,30);
        desttf.setBounds(450,70,150,30);
        dojlb.setBounds(300,110,150,30);
        dojtf.setBounds(450,110,150,30);
        classpreflb.setBounds(300,150,150,30);
        classpreftf.setBounds(450,150,150,30);
        planenamelb.setBounds(300,190,100,30);
        planenametf.setBounds(450,190,150,30);
        idcardlb.setBounds(300,230,150,30);
        idcardtf.setBounds(450,230,150,30);
        dllb.setBounds(300,270,150,30);
        dltf.setBounds(450,270,150,30);


//        to add booking id
        seatnotf.setBounds(50,370,450,30);
        bookingid.setBounds(50,320,450,30);


//to add button
        bookTicketBtn.setBounds(100,420,120,30);
        cancelbtn.setBounds(250,420,120,30);
        clearbtn.setBounds(400,420,120,30);


//        to add components on frame
        frame.add(idcardlb);
        frame.add(idcardtf);
        frame.add(dllb);
        frame.add(dltf);
        frame.add(panlb);
        frame.add(pantf);
        frame.add(aadharlb);
        frame.add(aadhartf);
        frame.add(namelb);
        frame.add(nametf);
        frame.add(emaillb);
        frame.add(emailtf);
        frame.add(mobnolb);
        frame.add(mobnotf);
        frame.add(sourcelb);
        frame.add(sourcetf);
        frame.add(destlb);
        frame.add(desttf);
        frame.add(dojlb);
        frame.add(dojtf);
        frame.add(agelb);
        frame.add(ageltf);
        frame.add(genderlb);
        frame.add(gendertf);
        frame.add(planenamelb);
        frame.add(planenametf);
        frame.add(seatnotf);
        frame.add(classpreflb);
        frame.add(classpreftf);
        frame.add(bookTicketBtn);
        frame.add(cancelbtn);
        frame.add(clearbtn);
        frame.add(bookingid);

//        when clicked on clear btn it clears the form
        clearbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("Clear button clicked!");
                nametf.setText("");
                emailtf.setText("");
                mobnotf.setText("");
                sourcetf.setText("");
                desttf.setText("");
                dojtf.setText("");
                ageltf.setText("");
                gendertf.setText("");
                aadhartf.setText("");
                pantf.setText("");
                seatnotf.setText("");
                classpreftf.setText("");
                idcardtf.setText("");
                planenametf.setText("");
                dltf.setText("");
            }
        });
//for exit btn
        cancelbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

//    for book btn
        bookTicketBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //add the validation of form can't be empty
                if (
                        nametf.getText().toString().isEmpty() ||
                        emailtf.getText().toString().isEmpty() ||
                        mobnotf.getText().toString().isEmpty() ||
                        ageltf.getText().toString().isEmpty() ||
                        gendertf.getText().toString().isEmpty() ||
                        aadhartf.getText().toString().isEmpty() ||
                        pantf.getText().toString().isEmpty() ||
                        sourcetf.getText().toString().isEmpty() ||
                        desttf.getText().toString().isEmpty() ||
                        dojtf.getText().toString().isEmpty() ||
                        classpreftf.getText().toString().isEmpty() ||
                        planenametf.getText().toString().isEmpty() ||
                        idcardtf.getText().toString().isEmpty() ||
                        dltf.getText().toString().isEmpty())

                {
                    bookingid.setText("Please fill the details");
                }
                else {
                    String url="jdbc:mysql://localhost:3306/flightmanagesyatem";
                    String username = "root";
                    String password = "";
                    try {
                        Connection connection = DriverManager.getConnection(url, username, password);
                        String sql = "insert into ticket"
                                + " values (null, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?,?,?)";
                        PreparedStatement preparedStmt = connection.prepareStatement(sql);
                        preparedStmt.setString (1, nametf.getText().toString());
                        preparedStmt.setString (2, emailtf.getText().toString());
                        preparedStmt.setString   (3, mobnotf.getText().toString());
                        preparedStmt.setString(4, ageltf.getText().toString());
                        preparedStmt.setString    (5, gendertf.getText().toString());
                        preparedStmt.setString    (6, aadhartf.getText().toString());
                        preparedStmt.setString    (7, pantf.getText().toString());
                        preparedStmt.setString    (8, sourcetf.getText().toString());
                        preparedStmt.setString    (9, desttf.getText().toString());
                        preparedStmt.setString    (10, dojtf.getText().toString());
                        preparedStmt.setString    (11, classpreftf.getText().toString());
                        preparedStmt.setString    (12, planenametf.getText().toString());
                        preparedStmt.setString    (13, idcardtf.getText().toString());
                        preparedStmt.setString    (14, dltf.getText().toString());
                        preparedStmt.execute();
                        System.out.println("Db connected");
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex+ "not Connected");
                    }

                    Random random = new Random();
                    int id = random.nextInt(999999);
                    bookingid.setText("Your booking is confirmed and bookind id " + id);
                    int no = random.nextInt(99);
                    seatnotf.setText("Your flight seat no is " + no);
                }


            }
        });

        frame.setResizable(false);
        frame.setLayout(null);
        frame.setSize(630, 500);
        frame.setVisible(true);
    }
}




