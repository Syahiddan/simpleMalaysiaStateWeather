package FinalLab;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import org.json.JSONException;
import org.json.JSONObject;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JSlider;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class View {

	private JFrame frame;
	private JTextField inputApiKey;
	private JTextField inputLongitude;
	private JTextField inputLatitude;
	static View window;
	JComboBox<String> comboBox;
	ArrayList<MalaysiaState> states = new ArrayList<>();
	JTextArea result;
	private JTextField inputSourcePlace;
	private JTextField inputWeather;
	private JTextField inputDescription;
	private JTextField inputHumidity;
	private JTextField inputTemperature;
	private JTextField inputWindSpeed;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new View();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public View() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void malaysiaState()
	{
		MalaysiaState kelantan = new MalaysiaState("Kelantan",102.24,6.13);
		MalaysiaState terengganu = new MalaysiaState("Terengganu",103.13,5.13);
		MalaysiaState pahang = new MalaysiaState("Pahang",103.33,3.81);
		MalaysiaState johor = new MalaysiaState("Johor",103.76,1.49);
		MalaysiaState melaka = new MalaysiaState("Melaka",102.25,2.14);
		MalaysiaState negeri9 = new MalaysiaState("Negeri Sembilan",101.94,2.73);
		MalaysiaState selangor = new MalaysiaState("Selangor",101.52,3.07);
		MalaysiaState wilayahP = new MalaysiaState("Wilayah Persekutuan",101.69,3.14);
		MalaysiaState perak = new MalaysiaState("Perak",101.09,4.59);
		MalaysiaState kedah = new MalaysiaState("Kedah",100.37,6.12);
		MalaysiaState perlis = new MalaysiaState("Perlis",100.20,6.44);
		MalaysiaState sarawak = new MalaysiaState("Sarawak",110.36,1.55);
		MalaysiaState sabah = new MalaysiaState("Sabah",116.08,5.98);
		
		states.add(kelantan);
		states.add(terengganu);
		states.add(pahang);
		states.add(johor);
		states.add(melaka);
		states.add(negeri9);
		states.add(selangor);
		states.add(wilayahP);
		states.add(perak);
		states.add(kedah);
		states.add(perlis);
		states.add(sarawak);
		states.add(sabah);
		
		comboBox.addItem(kelantan.getName());
		comboBox.addItem(terengganu.getName());
		comboBox.addItem(pahang.getName());
		comboBox.addItem(johor.getName());
		comboBox.addItem(melaka.getName());
		comboBox.addItem(negeri9.getName());
		comboBox.addItem(selangor.getName());
		comboBox.addItem(wilayahP.getName());
		comboBox.addItem(perak.getName());
		comboBox.addItem(kedah.getName());
		comboBox.addItem(perlis.getName());
		comboBox.addItem(sarawak.getName());
		comboBox.addItem(sabah.getName());
		
		inputLongitude.setText(String.valueOf(kelantan.getLongitude()));
		inputLatitude.setText(String.valueOf(kelantan.getLatitude()));
		
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					double longitude = 0.0;
					double latitude = 0.0;
					for(int i = 0 ; i < states.size(); i ++)
					{
						if(states.get(i).getName() == e.getItem().toString())
						{
							longitude =  states.get(i).getLongitude();
							latitude = states.get(i).getLatitude();
							break;
						}
					}
					inputLongitude.setText(String.valueOf(longitude));
					inputLatitude.setText(String.valueOf(latitude));
				}
				
			}
		});
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 685, 509);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblWeatherInformation = new JLabel("Weather Information");
		lblWeatherInformation.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblWeatherInformation.setHorizontalAlignment(SwingConstants.CENTER);
		lblWeatherInformation.setHorizontalTextPosition(SwingConstants.CENTER);
		lblWeatherInformation.setBounds(252, 29, 185, 36);
		frame.getContentPane().add(lblWeatherInformation);
		
		inputApiKey = new JTextField();
		inputApiKey.setBounds(88, 76, 527, 20);
		frame.getContentPane().add(inputApiKey);
		inputApiKey.setColumns(10);
		
		JLabel lblApiKey = new JLabel("API KEY :");
		lblApiKey.setBounds(32, 79, 57, 14);
		frame.getContentPane().add(lblApiKey);
		
		JLabel lblLongitude = new JLabel("Longitude :");
		lblLongitude.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLongitude.setBounds(404, 117, 78, 14);
		frame.getContentPane().add(lblLongitude);
		
		inputLongitude = new JTextField();
		inputLongitude.setBounds(492, 114, 123, 20);
		inputLongitude.setEditable(false);
		frame.getContentPane().add(inputLongitude);
		inputLongitude.setColumns(10);
		
		JLabel lblLatitude = new JLabel("Latitude :");
		lblLatitude.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLatitude.setBounds(404, 153, 78, 14);
		frame.getContentPane().add(lblLatitude);
		
		inputLatitude = new JTextField();
		inputLatitude.setBounds(492, 150, 123, 20);
		inputLatitude.setEditable(false);
		frame.getContentPane().add(inputLatitude);
		inputLatitude.setColumns(10);
		
		result = new JTextArea();
		result.setWrapStyleWord(true);
		result.setRows(50);
		result.setColumns(20);
		result.setBounds(32, 210, 583, 20);
		result.setVisible(false);
		frame.getContentPane().add(result);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Thread thread = new Thread() {
					public void run()
					{
						
						Request request = new Request();
						request.setUrl("http://api.openweathermap.org/data/2.5/weather");
						request.setView(window);
						request.setLatitude(Double.parseDouble(inputLatitude.getText()));
						request.setLongitude(Double.parseDouble(inputLongitude.getText()));
						request.setApiKey(inputApiKey.getText());
						request.getHttpResponse();
						if(request.isSuccess())
						{
							try {
								JSONObject main = (JSONObject) request.getJsonObject();
								JSONObject weather = (JSONObject) main.getJSONArray("weather").get(0);
								JSONObject mainTemp = main.getJSONObject("main");
								JSONObject windObj = main.getJSONObject("wind");
								
								result.setText(main.getString("name"));
								inputSourcePlace.setText(main.getString("name"));
								inputWeather.setText(weather.getString("main"));
								inputDescription.setText(weather.getString("description"));
								inputHumidity.setText(String.valueOf(mainTemp.getDouble("humidity")));
								
								double toCelcius = mainTemp.getDouble("temp") - 273.15;
								inputTemperature.setText(String.format("%.2f", toCelcius));
								double toMetreSecond = windObj.getDouble("speed") * 1603.34;
								inputWindSpeed.setText(String.format("%.2f", toMetreSecond));
								
							} catch (JSONException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						else
						{
							JOptionPane.showMessageDialog(frame, "Invalid API Key, please try again.");
						}
						
						//af7dfc4e53c7746966f0b8457553e508
					}
				};
				thread.start();
			}
		});
		btnSubmit.setBounds(32, 176, 583, 23);
		frame.getContentPane().add(btnSubmit);
		
		comboBox = new JComboBox<String>();
		
		comboBox.setBounds(88, 114, 283, 20);
		frame.getContentPane().add(comboBox);
		
		JLabel lblState = new JLabel("State :");
		lblState.setBounds(32, 117, 46, 14);
		frame.getContentPane().add(lblState);
		
		JLabel lblCurrent = new JLabel("CURRENT");
		lblCurrent.setHorizontalAlignment(SwingConstants.CENTER);
		lblCurrent.setBounds(269, 229, 102, 14);
		frame.getContentPane().add(lblCurrent);
		
		JLabel lblSource = new JLabel("Source Place :");
		lblSource.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSource.setBounds(10, 258, 82, 14);
		frame.getContentPane().add(lblSource);
		
		inputSourcePlace = new JTextField();
		inputSourcePlace.setBounds(102, 255, 195, 20);
		frame.getContentPane().add(inputSourcePlace);
		inputSourcePlace.setColumns(10);
		
		JLabel lblWeather = new JLabel("Weather :");
		lblWeather.setHorizontalAlignment(SwingConstants.RIGHT);
		lblWeather.setBounds(32, 283, 57, 14);
		frame.getContentPane().add(lblWeather);
		
		inputWeather = new JTextField();
		inputWeather.setBounds(102, 280, 195, 20);
		frame.getContentPane().add(inputWeather);
		inputWeather.setColumns(10);
		
		JLabel lblDescription = new JLabel("Description :");
		lblDescription.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDescription.setBounds(18, 308, 74, 14);
		frame.getContentPane().add(lblDescription);
		
		inputDescription = new JTextField();
		inputDescription.setBounds(102, 305, 195, 54);
		frame.getContentPane().add(inputDescription);
		inputDescription.setColumns(10);
		
		JLabel lblHumidity = new JLabel("Humidity :");
		lblHumidity.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHumidity.setBounds(314, 258, 83, 14);
		frame.getContentPane().add(lblHumidity);
		
		inputHumidity = new JTextField();
		inputHumidity.setBounds(407, 255, 143, 20);
		frame.getContentPane().add(inputHumidity);
		inputHumidity.setColumns(10);
		
		JLabel lblTemperature = new JLabel("Temperature :");
		lblTemperature.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTemperature.setBounds(307, 283, 90, 14);
		frame.getContentPane().add(lblTemperature);
		
		inputTemperature = new JTextField();
		inputTemperature.setBounds(407, 280, 143, 20);
		frame.getContentPane().add(inputTemperature);
		inputTemperature.setColumns(10);
		
		JLabel label = new JLabel("%");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(559, 253, 29, 20);
		frame.getContentPane().add(label);
		
		JLabel lblNewLabel = new JLabel("\u00B0c");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(559, 281, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Wind Speed :");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(307, 308, 90, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		inputWindSpeed = new JTextField();
		inputWindSpeed.setBounds(407, 305, 143, 20);
		frame.getContentPane().add(inputWindSpeed);
		inputWindSpeed.setColumns(10);
		
		JLabel lblMs = new JLabel("m/s");
		lblMs.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMs.setBounds(559, 306, 23, 14);
		frame.getContentPane().add(lblMs);
		malaysiaState();
	}
}
