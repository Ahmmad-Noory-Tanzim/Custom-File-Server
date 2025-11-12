import { useState } from "react";

export default function DownloadPage() {
  const [filename, setFilename] = useState("VisioPro2021Retail.img");

  const downloadFile = () => {
    const url = `/api/files/${filename}`; //for dev `http://192.168.1.245:8080/api/files/${filename}`
    console.log("Downloading from URL:", url);
    const a = document.createElement("a");
    a.href = url;
    a.download = filename; // browser handles large files
    a.click();
  };

  return (
    <div className="min-h-screen flex items-center justify-center animated-gradient">
      <div className="bg-white shadow-xl p-10 w-full max-w-md">
        <h1 className="text-2xl font-bold text-center text-indigo-700 mb-6">
          File Downloader
        </h1>

        <div className="mb-4">
          <label
            htmlFor="filename"
            className="block text-sm font-medium text-gray-700 mb-1"
          >
            File Name
          </label>
          <input
            id="filename"
            type="text"
            value={filename}
            onChange={(e) => setFilename(e.target.value)}
            className="w-full px-4 py-2 border border-gray-300 rounded-lg focus:ring-indigo-500 focus:border-indigo-500 shadow-sm"
            placeholder="Enter filename (e.g., raspbian.img)"
          />
        </div>

        <button
          onClick={downloadFile}
          className="w-full bg-indigo-600 text-white font-semibold py-3 rounded-xl hover:bg-indigo-700 transition-colors shadow-md"
        >
          Download
        </button>

        <p className="text-center text-gray-500 text-sm mt-4">
          The browser will handle the download automatically.
        </p>
      </div>
    </div>
  );
}
