//public static List<DEAlib_TriangleData> DEAlib_Triangulate(List<Vector2f> list) {
//        //org.orbisgis:poly2tri-core:0.1.2
////thank god stackoverflow exists
//// https://stackoverflow.com/questions/23597434/how-to-triangulate-tesselate-some-shape-in-java
//
//        List<org.poly2tri.geometry.polygon.PolygonPoint> polygonPointList = new ArrayList<>();
//
//        //Create the polygon
//        for (Vector2f location : list) {
//        org.poly2tri.geometry.polygon.PolygonPoint point = new org.poly2tri.geometry.polygon.PolygonPoint((double) location.x, (double) location.y);
//
//        polygonPointList.add(point);
//        }
//        Polygon polygon = new Polygon(polygonPointList);
//        //passing a List of PolygonPoints
//
//
//        //Next, proceed to calculate the triangulation of the polygon
//        Poly2Tri.triangulate(polygon);
//
//        //Finally, obtain the resulting triangles
//        List<DelaunayTriangle> triangles = polygon.getTriangles();
//
//        List<DEAlib_TriangleData> dealib_triangleDataList = new ArrayList<>();
//
//        for (DelaunayTriangle triangle : triangles) {//scrolls through triangles
//        TriangulationPoint[] triangulationPoints = triangle.points;
//
//        DEAlib_TriangleData dealib_triangle = new DEAlib_TriangleData();
//
//        for (TriangulationPoint triangulationPoint : triangulationPoints) {
//
//        dealib_triangle.corner1 = new Vector2f((float) triangulationPoint.getX(), (float) triangulationPoint.getY());
//
//
//        }
//
//        dealib_triangleDataList.add(dealib_triangle);
//
//        }
//
//        return dealib_triangleDataList;
//
//        }