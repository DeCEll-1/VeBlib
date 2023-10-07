//public void DEAlib_DrawSphere(float radius, int slices, int stacks, SpriteAPI texture, ViewportAPI viewport) {
////powered by chatgpt:tm:
//
//
//
//        texture.bindTexture();
//        radius = radius;
//        slices = slices;
//        stacks = stacks;
//
//
//        for (int i = 0; i < stacks; i++) {
//        float latitude1 = (float) Math.PI * (-0.5f + (float) (i) / stacks);
//        float latitude2 = (float) Math.PI * (-0.5f + (float) (i + 1) / stacks);
//        float sinLat1 = (float) Math.sin(latitude1);
//        float cosLat1 = (float) Math.cos(latitude1);
//        float sinLat2 = (float) Math.sin(latitude2);
//        float cosLat2 = (float) Math.cos(latitude2);
//
//        glBegin(GL_TRIANGLE_STRIP);
//        for (int j = 0; j <= slices; j++) {
//        float longitude = 2.0f * (float) Math.PI * (float) (j - 1) / slices;
//        float sinLong = (float) Math.sin(longitude);
//        float cosLong = (float) Math.cos(longitude);
//        float x1 = cosLong * cosLat1;
//        float y1 = sinLat1;
//        float z1 = sinLong * cosLat1;
//        float x2 = cosLong * cosLat2;
//        float y2 = sinLat2;
//        float z2 = sinLong * cosLat2;
//
//
//        glTexCoord2f(viewport.convertWorldXtoScreenX((float) j / slices), viewport.convertScreenYToWorldY((float) i / stacks));
//        glVertex3f(viewport.convertWorldXtoScreenX(x1 * radius), viewport.convertScreenYToWorldY(y1 * radius), z1 * radius);
//        glTexCoord2f(viewport.convertWorldXtoScreenX((float) j / slices), viewport.convertScreenYToWorldY((float) (i + 1) / stacks));
//        glVertex3f(viewport.convertWorldXtoScreenX(x2 * radius), viewport.convertScreenYToWorldY(y2 * radius), z2 * radius);
//        }
//        glEnd();
//        }
//        }