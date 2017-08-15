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

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import models.Usuario;
import networking.HttpHandler;

public class TestRestFragment extends Fragment {
    private EditText txtName, txtLastName, txtEmail, txtPassword;
    private Button signIn, show, edit;
    private TextView rawData;
    private HttpHandler httpHandler;
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
        edit = (Button) view.findViewById(R.id.btnUpdate);
        show = (Button) view.findViewById(R.id.getServiceData);
        rawData = (TextView) view.findViewById(R.id.rawJsonData);

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread service = new Thread() {
                    @Override
                    public void run() {
                        httpHandler = new HttpHandler();
                        final String res = httpHandler.get("http://172.29.57.104:1337/Usuario");
                        try {
                            final JSONArray jArray = (JSONArray) new JSONTokener(res).nextValue();
                            final JSONObject usuario = jArray.getJSONObject(0);
                            Gson gson = new Gson();
                            final Usuario user = gson.fromJson(usuario.toString(), Usuario.class);
                            JSONArray jsonArray = usuario.getJSONArray("favoritos");
                            final JSONObject jsonObject = jsonArray.getJSONObject(0);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    rawData.setText(res);
                                    txtName.setText(user.getNombre());
                                    txtLastName.setText(user.getApellido());
                                    txtEmail.setText(user.getCorreo());
                                    txtPassword.setText(user.getPassword());
                                }
                            });
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                service.start();
            }
        });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread service = new Thread() {
                    @Override
                    public void run() {
                        HashMap<String, String> params = new HashMap<>();
                        params.put("nombre", txtName.getText().toString());
                        params.put("apellido", txtLastName.getText().toString());
                        params.put("correo", txtEmail.getText().toString());
                        params.put("password", txtPassword.getText().toString());
                        httpHandler = new HttpHandler();
                        final String res = httpHandler.post("http://172.29.57.104:1337/Usuario", params);
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

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread service = new Thread() {
                    @Override
                    public void run() {
                        HashMap<String, String> params = new HashMap<>();
                        params.put("nombre", txtName.getText().toString());
                        params.put("apellido", txtLastName.getText().toString());
                        params.put("correo", txtEmail.getText().toString());
                        params.put("password", txtPassword.getText().toString());
                        httpHandler = new HttpHandler();
                        final String res = httpHandler.put("http://172.29.57.104:1337/Usuario", params);
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
