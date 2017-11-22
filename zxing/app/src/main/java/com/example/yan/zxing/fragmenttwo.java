package com.example.yan.zxing;

import android.graphics.Bitmap;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import java.lang.reflect.GenericArrayType;

/**
 * Created by Yan on 2017/11/6.
 */

public class fragmenttwo extends Fragment {

    private ImageView image;
    private TextView text;
    private Button btn;
    private String test;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment2,container,false);
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        image=(ImageView)getActivity().findViewById(R.id.image);
        text=(TextView) getActivity().findViewById(R.id.text);
        btn=(Button) getActivity().findViewById(R.id.create);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                test=text.getText().toString();
                Bitmap a=encodeAsBitmap(test);
                image.setImageBitmap(a);
            }
        });
    }


    Bitmap encodeAsBitmap(String str) {
        Bitmap bitmap = null;
        BitMatrix result = null;
        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        try {
            //查看各参数解析
            result = multiFormatWriter.encode(str, BarcodeFormat.CODE_128, 800, 300);
            // 使用 ZXing Android Embedded 要写的代码
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            bitmap = barcodeEncoder.createBitmap(result);
        } catch (WriterException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException iae) {
            return null;
        }
        return bitmap;
    }
}
