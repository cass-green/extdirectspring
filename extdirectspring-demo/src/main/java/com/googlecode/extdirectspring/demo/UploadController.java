/**
 * Copyright 2010 Ralph Schaer
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.googlecode.extdirectspring.demo;

import java.io.IOException;
import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.googlecode.extdirectspring.annotation.ExtDirectMethod;
import com.googlecode.extdirectspring.bean.ExtDirectResponseBuilder;

@Controller
public class UploadController {

  @ExtDirectMethod
  @ResponseBody
  @RequestMapping(value = "/uploadTest", method = RequestMethod.POST)
  public String uploadTest(Locale locale, HttpServletRequest request, @RequestParam("fileUpload") MultipartFile file) throws IOException {

    ExtDirectResponseBuilder builder = new ExtDirectResponseBuilder(request);
    
    if (file != null && !file.isEmpty()) {
      builder.addResultProperty("fileContents", new String(file.getBytes()));
    }

    return builder.buildUploadResponse();
  }
}
