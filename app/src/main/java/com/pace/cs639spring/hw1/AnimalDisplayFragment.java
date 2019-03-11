package com.pace.cs639spring.hw1;

import android.support.v4.app.Fragment;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Created by kachi on 1/31/18.
 * Created by Avtar Singh Bamra
 */

public class AnimalDisplayFragment extends Fragment {

    //Utility function to convert dp to pixel
    private float dpToPx(int dpValue) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpValue, getResources().getDisplayMetrics());
    }

    //Variable to store the selected object. Initialize to None when no image selected
    public String selectedObject="None";


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.animal_display, container, false);

        //Initialize ImageView
        ImageView birdImage = view.findViewById(R.id.birdImageView);
        ImageView catImage = view.findViewById(R.id.catImageView);
        ImageView dogImage = view.findViewById(R.id.dogImageView);

        //Initialize TextViews
        TextView birdText = view.findViewById(R.id.birdTextView);
        TextView catText = view.findViewById(R.id.catTextView);
        TextView dogText = view.findViewById(R.id.dogTextView);

        //Initialize Buttons
        Button rotateButton = view.findViewById(R.id.rotateButton);
        Button flipButton = view.findViewById(R.id.flipButton);
        ImageView resetButton = view.findViewById(R.id.resetController);
        ImageView moveLeftButton = view.findViewById(R.id.leftArrow);
        ImageView moveRightButton = view.findViewById(R.id.rightArrow);
        ImageView moveUpButton = view.findViewById(R.id.topArrow);
        ImageView moveDownButton = view.findViewById(R.id.downArrow);


        // Set the visibility of the descriptions to invisible at the starting of application
        birdText.setVisibility(View.INVISIBLE);
        catText.setVisibility(View.INVISIBLE);
        dogText.setVisibility(View.INVISIBLE);


        //Create Click event listeners for each ImageView
        birdImage.setOnClickListener(imageView -> {
            if (birdText.getVisibility() == View.INVISIBLE) {
                selectedObject="Bird";
                birdText.setVisibility(View.VISIBLE);
                catText.setVisibility(View.INVISIBLE);
                dogText.setVisibility(View.INVISIBLE);
            } else {
                selectedObject="None";
                birdText.setVisibility(View.INVISIBLE);
            }
        });

        catImage.setOnClickListener(imageView -> {
            if (catText.getVisibility() == View.INVISIBLE) {
                selectedObject="Cat";
                catText.setVisibility(View.VISIBLE);
                birdText.setVisibility(View.INVISIBLE);
                dogText.setVisibility(View.INVISIBLE);
            } else {
                selectedObject="None";
                catText.setVisibility(View.INVISIBLE);
            }
        });

        dogImage.setOnClickListener(imageView -> {
            if (dogText.getVisibility() == View.INVISIBLE) {
                selectedObject="Dog";
                dogText.setVisibility(View.VISIBLE);
                catText.setVisibility(View.INVISIBLE);
                birdText.setVisibility(View.INVISIBLE);
            } else {
                selectedObject="None";
                dogText.setVisibility(View.INVISIBLE);
            }
        });

        //Create click event listener for all buttons

        //Rotate function
        rotateButton.setOnClickListener(buttonView -> {
            switch(selectedObject){
                case "Bird":
                    birdImage.setRotation(birdImage.getRotation()+90);
                    break;
                case "Cat":
                    catImage.setRotation(catImage.getRotation()+ 90);
                    break;
                case "Dog":
                    dogImage.setRotation(dogImage.getRotation()+90);
                    break;
                case "None":
                    generateToastMessage();
                    break;
            }
        });

        //Flip functionality
        flipButton.setOnClickListener(buttonView -> {
            switch(selectedObject){
                case "Bird":
                    birdImage.setRotationY(birdImage.getRotationY() + 180);
                    break;
                case "Cat":
                    catImage.setRotationY(catImage.getRotationY() + 180);
                    break;
                case "Dog":
                    dogImage.setRotationY(dogImage.getRotationY() + 180);
                    break;
                case "None":
                    generateToastMessage();
                    break;
            }
        });


        //Move Left Function
        moveLeftButton.setOnClickListener(buttonView -> {
                switch(selectedObject){
                    case "Bird":
                        birdImage.setTranslationX(birdImage.getTranslationX() - dpToPx(10));
                        break;
                    case "Dog":
                        dogImage.setTranslationX(dogImage.getTranslationX() - dpToPx(10));
                        break;
                    case "Cat":
                        catImage.setTranslationX(catImage.getTranslationX() - dpToPx(10));
                        break;
                    case "None":
                        generateToastMessage();
                        break;
                }
        });

        //Move Right Functionality
        moveRightButton.setOnClickListener(buttonView -> {
            switch(selectedObject){
                case "Bird":
                    birdImage.setTranslationX(birdImage.getTranslationX() + dpToPx(10));
                    break;
                case "Dog":
                    dogImage.setTranslationX(dogImage.getTranslationX() + dpToPx(10));
                    break;
                case "Cat":
                    catImage.setTranslationX(catImage.getTranslationX() + dpToPx(10));
                    break;
                case "None":
                    generateToastMessage();
                    break;
            }
        });

        //Move Up Functionality
        moveUpButton.setOnClickListener(buttonView -> {
            switch(selectedObject){
                case "Bird":
                    birdImage.setTranslationY(birdImage.getTranslationY() - dpToPx(10));
                    break;
                case "Dog":
                    dogImage.setTranslationY(dogImage.getTranslationY() - dpToPx(10));
                    break;
                case "Cat":
                    catImage.setTranslationY(catImage.getTranslationY() - dpToPx(10));
                    break;
                case "None":
                    generateToastMessage();
                    break;
            }
        });


        //Move Down Function
        moveDownButton.setOnClickListener(buttonView -> {
            switch(selectedObject){
                case "Bird":
                    birdImage.setTranslationY(birdImage.getTranslationY() + dpToPx(10));
                    break;
                case "Dog":
                    dogImage.setTranslationY(dogImage.getTranslationY() + dpToPx(10));
                    break;
                case "Cat":
                    catImage.setTranslationY(catImage.getTranslationY() + dpToPx(10));
                    break;
                case "None":
                    generateToastMessage();
                    break;
            }
        });


        //Reset Controller Function
        resetButton.setOnClickListener(buttonView -> {
            switch(selectedObject){
                case "Bird":
                    birdImage.setTranslationX(0);
                    birdImage.setTranslationY(0);
                    break;
                case "Dog":
                    dogImage.setTranslationX(0);
                    dogImage.setTranslationY(0);
                    break;
                case "Cat":
                    catImage.setTranslationX(0);
                    catImage.setTranslationY(0);
                    break;
                case "None":
                    generateToastMessage();
                    break;
            }
        });

        return view;
    }


    //Utility function to display toast message
    private void generateToastMessage() {
        Toast.makeText(getContext(), R.string.please_select_an_animal_image_before_choosing_an_image_modification, Toast.LENGTH_LONG).show();
    }




}
