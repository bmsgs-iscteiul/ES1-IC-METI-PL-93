package _ES._ES;

import static org.junit.Assert.*;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import org.junit.Before;
import org.junit.Test;

public class DatatableTest {

	App app;
	
	@Before
	public void setUp() throws Exception {
		app = new App();
	}

	@Test
	public void test() {
		JFrame frame = new JFrame();  
        frame.setTitle("Teste JUnit");
        
        JScrollPane sp = new JScrollPane(new Datatable(app.detectDefects(null)).getJTable()); 
        frame.add(sp); 
        // Frame Size 
        frame.setSize(500, 200); 
        // Frame Visible = true 
        frame.setVisible(true);
	}

}