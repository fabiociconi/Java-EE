package samples.chapter4.photo.servlets;

import java.io.IOException;
import java.io.OutputStream;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import samples.chapter4.photo.EditPhoto;
import samples.chapter4.photo.Photo;
import samples.chapter4.photo.PhotoAlbum;

/**
 * Servlet implementation class DisplayPhotoServlet
 */
@WebServlet("/DisplayPhotoServlet")
public class DisplayPhotoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
    PhotoAlbum photoAlbum;
    @Inject
    EditPhoto uploadBean;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayPhotoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        byte[] photoData;
        String indexString = request.getParameter("photoid");
        if (indexString != null) {
            long id = (new Long(indexString.trim())).longValue();
            Photo photo = photoAlbum.getPhoto(id);
            photoData = photo.getData();
        } else {
            photoData = uploadBean.getPhotoData();
        }
        response.setContentType("image/jpeg");
        try (OutputStream out = response.getOutputStream()) {
            for (int i = 0; i < photoData.length; i++) {
                out.write( photoData[i]);
            }
        } 
    }

}
