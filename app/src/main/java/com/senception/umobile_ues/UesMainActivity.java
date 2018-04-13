/**
 * Copyright (C) 2015-2018 Senception Lda
 * UMOBILE End-user Service (UES)
 * @author Igor dos Santos - igor.santos@senception.com
 * @author José Soares - jose.soares@senception.com
 * @author Rute Sofia - rute.sofia@senception.com
 * @version 1.0
 *
 * @file Contains UesMainActivity
 * This class corresponds to the Ues frontend. It holds placers to call
 * UMOBILE native applications and services
 */


package com.senception.umobile_ues;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/*  The UesMainActivity is composed of multiple buttons which are used to call
 *  the different UMOBILE native applications and services
 */

public class UesMainActivity extends AppCompatActivity {
    Button oi, now, pml, route, context, direct, sharing, migration;
    boolean is_oi_active,is_now_active, is_pml_active, is_route_active, is_context_active, is_direct_active, is_sharing_active, is_migration_active = false;
    int backButtonCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ues_main);
        oi = (Button) findViewById(R.id.bt_oi);
        now = (Button) findViewById(R.id.bt_now);
        pml = (Button) findViewById(R.id.bt_pml);
       // route = (Button) findViewById(R.id.bt_route);
        context = (Button) findViewById(R.id.bt_contextualization);
        direct = (Button) findViewById(R.id.bt_direct);
        sharing = (Button) findViewById(R.id.bt_sharing);
       // migration = (Button) findViewById(R.id.bt_service);

        /* sets a listener for the Oi! instant messenger (provided by partner COPELABS)
         *provided in UMOBILE
         * When pressed, it opens the external Oi! apk
         */

        oi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!is_oi_active) {

                    String package_name = "pt.ulusofona.copelabs.oi";
                    start_external_app(package_name);

                    oi.setBackgroundResource(R.drawable.button_pressed_corner);
                    is_oi_active = true;
                }
                else{
                    oi.setBackgroundResource(R.drawable.button_corner);
                    is_oi_active = false;
                }

            }
        });

        /* sets a listener for the Now@ content distribution application (provided by partner COPELABS)
         *provided in UMOBILE
         * When pressed, it opens the external Now@ apk
         */

         // TODO: Now@ is not yet available

        now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!is_now_active) {

                    String package_name = "pt.ulusofona.copelabs.now";
                    start_external_app(package_name);

                    context.setBackgroundResource(R.drawable.button_pressed_corner);
                    direct.setBackgroundResource(R.drawable.button_pressed_corner);
                    now.setBackgroundResource(R.drawable.button_pressed_corner);
                    is_now_active = true;
                }
                else{
                    context.setBackgroundResource(R.drawable.button_corner);
                    direct.setBackgroundResource(R.drawable.button_corner);
                    now.setBackgroundResource(R.drawable.button_corner);
                    is_now_active = false;
                }
            }
        });

        /* sets a listener for the PerSense Mobile Light data capture application
         *provided in UMOBILE (provided by partner Senception Lda)
         * When pressed, it opens the external Now@ apk
         */
        pml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!is_pml_active) {

                    String package_name = "com.senception.persenselight";
                    start_external_app(package_name);

                    pml.setBackgroundResource(R.drawable.button_pressed_corner);
                    is_pml_active = true;
                }
                else{
                    pml.setBackgroundResource(R.drawable.button_corner);
                    is_pml_active = false;
                }
            }
        });

        /*
        route.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!is_route_active) {
                    route.setBackgroundResource(R.drawable.button_pressed_corner);
                    is_route_active = true;
                }
                else{
                    route.setBackgroundResource(R.drawable.button_corner);
                    is_route_active = false;
                }
            }
        });
*/
        /* sets a listener for the Contextual Manager service of UMOBILE (provided by partner
         * Senception Lda
         * When pressed, it activates the service apk, which runs in foreground
         */
        context.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!is_context_active) {
                    String package_name = "com.senception.contextualmanager";
                    start_external_app(package_name);

                    context.setBackgroundResource(R.drawable.button_pressed_corner);
                    is_context_active = true;
                }
                else{
                    context.setBackgroundResource(R.drawable.button_corner);
                    is_context_active = false;
                }
            }
        });

         /* sets a listener for the Direct communication service of UMOBILE (provided by partner
         *  COPELABS), named NDN-Opp
         * When pressed, it activates the NDN-Opp service apk, which runs in foreground
         */

        direct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!is_direct_active) {
                    direct.setBackgroundResource(R.drawable.button_pressed_corner);
                    is_direct_active = true;
                }
                else{
                    direct.setBackgroundResource(R.drawable.button_corner);
                    is_direct_active = false;
                }
            }
        });

        /* sets a listener for the KEBAB service of UMOBILE
         * When pressed, it activates the KEBAB service apk, which runs in foreground
         */

        sharing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!is_sharing_active) {
                    sharing.setBackgroundResource(R.drawable.button_pressed_corner);
                    is_sharing_active = true;
                }
                else{
                    sharing.setBackgroundResource(R.drawable.button_corner);
                    is_sharing_active = false;
                }
            }
        });

/*
        migration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!is_migration_active) {
                    migration.setBackgroundResource(R.drawable.button_pressed_corner);
                    is_migration_active = true;
                }
                else{
                    migration.setBackgroundResource(R.drawable.button_corner);
                    is_migration_active = false;
                }
            }
        });
        */
    }

    /* starts an external apk
     * @param package_name the name of the package to be called, e.g., pt.domain.package
     */

    public void start_external_app(String package_name){

        PackageManager package_manager = getPackageManager();

        try{
            Intent intent = package_manager.getLaunchIntentForPackage(package_name);
            if(intent != null){
                startActivity(intent);
            }
        }
        catch (ActivityNotFoundException e){
            e.printStackTrace();
        }
    }
    @Override
    public void onBackPressed(){
        if(backButtonCount >= 1)
        {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(this, getString(R.string.mainback), Toast.LENGTH_SHORT).show();
            backButtonCount++;
        }
    }


}
