//package VeB.helper.test;
//
//import VeB.helper.VeBlib_Statics;
//
//public class VeBlib_XMLSerializerTEST {
//
//    public BaseClass XMLDeserialiserWS()
//    {
//        try
//        {
//            //ChatGPT yi daha yeni keşfettim :(
//
//            string documentsPath1 = Environment.GetFolderPath(Environment.SpecialFolder.MyDocuments);
//            string folderPath2 = Path.Combine(documentsPath1, "AnInterestingDesktopAppName");
//
//            if (!Directory.Exists(folderPath2))
//            {
//                Directory.CreateDirectory(folderPath2);
//            }
//
//            string filePath2 = Path.Combine(folderPath2, "Data.txt");
//            bool a = true;
//            if (!File.Exists(filePath2))
//            {
//                a = false;
//                File.Create(filePath2);
//            }
//
//            //DirectoryInfo di = new DirectoryInfo(@"C:\Program Files\AnInterestingDesktopAppName");
//            //if (!di.Exists)
//            //{
//            //    di.Create();
//            //}
//            //FileInfo fid = new FileInfo(@"C:\Program Files\AnInterestingDesktopAppName/Data.txt");
//            //if (!fid.Exists)
//            //{
//            //    fid.Create();
//            //}
//
//            if (a)
//            {
//                string documentsPath = Environment.GetFolderPath(Environment.SpecialFolder.MyDocuments);
//                string dataFilePath = Path.Combine(documentsPath, "AnInterestingDesktopAppName", "Data.txt");
//
//                StreamReader sr = new StreamReader(dataFilePath);
//                var stringReader = new StringReader(sr.ReadToEnd());
//                var serializer = new XmlSerializer(typeof(BaseClass));
//                return (BaseClass)serializer.Deserialize(stringReader);
//            }
//            return null;
//        }
//        catch (Exception)
//        {
//            throw;
//        }
//    }
//
//    public void Save(BaseClass saveableThing)
//    {
//        string documentsPath = Environment.GetFolderPath(Environment.SpecialFolder.MyDocuments);
//
//        string folderPath = Path.Combine(documentsPath, "AnInterestingDesktopAppName");
//
//        string dataFilePath = Path.Combine(folderPath, "Data.txt");
//
//        using (StreamWriter sw = new StreamWriter(dataFilePath, false))
//        {
//            sw.Write(XMLSerialize(saveableThing));
//        }
//
//        Statics.db = saveableThing;
//    }
//
//    public string XMLSerialize(BaseClass thingToSerialize)
//    {
//        try
//        {
//            var stringWriter = new StringWriter();
//            var serializer = new XmlSerializer(typeof(BaseClass));
//            serializer.Serialize(stringWriter, thingToSerialize);
//            return stringWriter.ToString();
//        }
//        catch (Exception)
//        {
//            throw;
//        }
//    }
//
//    public BaseClass XMLDeseriliazier(string xmlData)
//    {
//        try
//        {
//            var stringReader = new StringReader(xmlData);
//            var serializer = new XmlSerializer(typeof(BaseClass));
//            return (BaseClass)serializer.Deserialize(stringReader);
//        }
//        catch (Exception)
//        {
//            throw;
//        }
//    }
//
//
//}
