package ru.oniip.tileServer.controller;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@RestController
public class TilesController {

    private static final Logger logger = LoggerFactory.getLogger(TilesController.class);

    @GetMapping(value = "/", produces = MediaType.IMAGE_PNG_VALUE)
    @ResponseBody
    public byte[] getTile(@RequestParam String schema, int z, int x, int y) throws IOException {
        String urlTile = "maps/" + schema + "/" + z + "/" + x + "/" + y +".png";
        logger.info("Загружается тайл " + urlTile);
        File file = new File(urlTile);
        InputStream in = new FileInputStream(file);
        return IOUtils.toByteArray(in);
    }

}
