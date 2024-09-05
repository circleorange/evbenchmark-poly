package com.realev.products.storage;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageStorageService {

	public String storeImage(MultipartFile imgFile) {
		// Implementation to store image and return the image URL
		// Could involve uploading to AWS S3, MinIO, ...
		// For now, assuming it return URL string
		String imgUrl = "https://image-store.com/" + imgFile.getOriginalFilename();

		return imgUrl;
	}
}

