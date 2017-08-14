package ec.edu.epn.finalmovilproject;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class TestRestFragment extends Fragment {
    private EditText txtName, txtLastName, txtEmail, txtPassword;
    private Button signIn, show;
    private TextView rawData;
    Handler mHandler = new Handler(Looper.getMainLooper());

    public TestRestFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_test_rest, container, false);
        txtName = (EditText) view.findViewById(R.id.txtName);
        txtLastName = (EditText) view.findViewById(R.id.txtLastName);
        txtEmail = (EditText) view.findViewById(R.id.txtEmail);
        txtPassword = (EditText) view.findViewById(R.id.txtPassword);
        signIn = (Button) view.findViewById(R.id.btnRegister);
        show = (Button) view.findViewById(R.id.getServiceData);
        rawData = (TextView) view.findViewById(R.id.rawJsonData);

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread service = new Thread() {
                    @Override
                    public void run() {
                        final String res = getData();
                        //rawData.setText(res);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                rawData.setText(res);
                            }
                        });
                    }
                };
                service.start();
            }
        });

        return view;
    }

    public final void runOnUiThread(Runnable action) {
        mHandler.post(action);
    }

    private String getData() {
        String res = "";
        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL("http://192.168.1.2:1337/Usuario");
            urlConnection = (HttpURLConnection) url.openConnection();
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            res = readStream(in);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            urlConnection.disconnect();
        }
        return res;
    }

    private String readStream(InputStream in) {
        BufferedReader reader = null;
        StringBuffer response = new StringBuffer();
        try {
            reader = new BufferedReader(new InputStreamReader(in));
            String line = "";
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return response.toString();
    }
}
